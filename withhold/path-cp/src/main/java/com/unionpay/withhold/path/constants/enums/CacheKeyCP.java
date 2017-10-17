package com.unionpay.withhold.path.constants.enums;



public enum CacheKeyCP {

    HOSTADDR("HOST_ADDRESS", "主机地址"), 
    HOSTPORT("HOST_HOST", "主机端口"),
    ;
    

    private String value;
    private final String displayName;

    CacheKeyCP(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CacheKeyCP parseOf(String value) {
        
        for (CacheKeyCP item : values())
            if (item.getValue().equals(value))
                return item;

        return null;
    }

//     public static void main(String[] args) {
//         System.out.println(ErrorCodeBusHZ.SIGN_FAILED.getDisplayName());
//         System.out.println(ErrorCodeBusHZ.SIGN_FAILED.getValue());
//         System.out.println(parseOf(ErrorCodeBusHZ.SIGN_FAILED.getValue()).getDisplayName());
//         System.out.print(ErrorCodeBusHZ.SIGN_FAILED);
//     }
}
