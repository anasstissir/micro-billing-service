package com.anass.microarchi.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "full", types = Bill.class)
public interface BillProjection {
    public Long getId();
    public Date getBillingDate();
    public Long getCustomerId();
    public Collection<ProductItem> getProductItems();
}
