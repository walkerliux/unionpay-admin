package com.unionpay.withhold.path.services.cache;

import com.unionpay.withhold.path.constants.enums.CacheKeyCP;

public interface DataCache {

    public String getValue(CacheKeyCP cacheKey);
}
