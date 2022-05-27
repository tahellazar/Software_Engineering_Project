package org.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "premadeProducts")
public class PreMadeProduct extends Product {

    @Column(name = "product_name")
    private String name;
    private int priceBeforeDiscount;
    private String mainColor;

    public enum ProductType {CATALOG, CUSTOM_CATALOG}

    private ProductType productType;
    private String description;
    private boolean isOrdered;

    //copyCtor for catalog product
    public PreMadeProduct(PreMadeProduct p) { //constructor
        super(p.getByteImage(), p.getPrice(),p.getAmount());
        this.priceBeforeDiscount = p.getPriceBeforeDiscount();
        this.name = p.getName();
        this.productType = p.getType() ;
        if(p.getType() == ProductType.CATALOG)
            this.description = p.getDescription();
        else
            if(p.getMainColor() != null)
                this.mainColor = p.getMainColor();
        this.isOrdered = p.isOrdered();
    }

    //Ctor for catalog product
    public PreMadeProduct(String name, String path, int price, String description, int priceBeforeDiscount, boolean isOrdered) { //constructor
        super(path, price);
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.name = name;
        this.productType = ProductType.CATALOG;
        this.description = description;
        this.isOrdered = isOrdered;
    }

    //Ctor for catalog product
    public PreMadeProduct(String name, byte[] image, int price, String description, int priceBeforeDiscount,boolean isOrdered) {
        super(image, price);
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.name = name;
        this.productType = ProductType.CATALOG;
        this.description = description;
        this.isOrdered = isOrdered;
    }

    //Ctor for custom-made catalog product
    public PreMadeProduct(String name, String path, int price, int priceBeforeDiscount, boolean isOrdered,String mainColor) { //constructor
        super(path, price);
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.name = name;
        this.mainColor = mainColor;
        this.productType = ProductType.CUSTOM_CATALOG;
        this.isOrdered = isOrdered;
    }

    //Ctor for custom-made catalog product
    public PreMadeProduct(String name, byte[] image, int price, int priceBeforeDiscount,boolean isOrdered, String mainColor) {
        super(image, price);
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.name = name;
        this.mainColor = mainColor;
        this.productType = ProductType.CUSTOM_CATALOG;
        this.isOrdered = isOrdered;
    }

    public PreMadeProduct() {

    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }

    public void setPriceBeforeDiscount(int priceBeforeDiscount) {
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getType() {
        return this.productType;
    }

    public String getMainColor() {
        return this.mainColor;
    }


    public boolean isOrdered() {
        return isOrdered;
    }


    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }
}
