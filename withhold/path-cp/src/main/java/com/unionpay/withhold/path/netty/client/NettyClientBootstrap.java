package com.unionpay.withhold.path.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Socket短连接客户端<br>
 * 建立连接发送消息成功后，关闭客户端
 * 
 * @author AlanMa
 *
 */
public class NettyClientBootstrap {

    private static final Logger log = LoggerFactory.getLogger(NettyClientBootstrap.class);
    private int port;
    private String host;
    private SocketChannel socketChannel;

    public NettyClientBootstrap(int port, String host) throws InterruptedException {
        this.port = port;
        this.host = host;
        start();
    }

    public void start() throws InterruptedException {
        System.out.println("========entered start()==========");
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(host, port);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new ByteArrayDecoder());
                socketChannel.pipeline().addLast(new ByteArrayEncoder());
                socketChannel.pipeline().addLast(new NettyClientHandler());
                socketChannel.pipeline().addLast("idleStateHandler", new IdleStateHandler(2000, 2000, 2000, TimeUnit.MILLISECONDS));
            }

            @Override
            public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                log.info("【触发事件】");
                if (evt instanceof IdleStateEvent) {
                    IdleStateEvent e = (IdleStateEvent) evt;
                    if (e.state() == IdleState.READER_IDLE) {
                        ctx.close();
                        log.error("【READER_IDLE 读超时】");
                    }
                    else if (e.state() == IdleState.WRITER_IDLE) {
                        log.error("【WRITER_IDLE 写超时】");
                    }
                    else {
                        log.error("【其他超时】");
                    }
                }
            }
        });
        // ChannelFuture future = bootstrap.connect(host, port).sync();
        ChannelFuture future = bootstrap.connect(host, port).awaitUninterruptibly();
        System.out.println("========future.isSuccess():" + future.isSuccess());
        if (future.isSuccess()) {
            socketChannel = (SocketChannel) future.channel();
            InetSocketAddress localAddress = socketChannel.localAddress();
            log.info("本地{}:{}-->{}:{} 连接成功", new Object[] { localAddress.getAddress().getHostAddress(), localAddress.getPort(), host, port });
            SocketChannelHelper channelHelper = SocketChannelHelper.getInstance();
            channelHelper.setLastActiveTime(new Date());
            channelHelper.setSocketKey(localAddress.getAddress().getHostAddress() + ":" + localAddress.getPort());
        }
    }

    public void sendMessage(byte[] msg) throws InterruptedException {
        try {
            log.info("[sendMessage]:" + new String(msg, "UTF-8"));
        }
        catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        socketChannel.writeAndFlush(msg);
    }

}
