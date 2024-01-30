/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emart.pojo;

/**
 *
 * @author rajpr
 */
public class  Productspojo {

    
//    public Productspojo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//    public Productspojo(String ProductId, String ProductName, String ProductCompany, double ProductPrice, double OurPrice, int Quantity,int tax ,double total) {
//        this.ProductId = ProductId;
//        this.ProductName = ProductName;
//        this.ProductCompany = ProductCompany;
//        this.ProductPrice = ProductPrice;
//        this.OurPrice = OurPrice;
//        this.Tax = Tax;
//        this.Quantity = Quantity;
//        this.total=total;
//    }



    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductCompany() {
        return ProductCompany;
    }

    public void setProductCompany(String ProductCompany) {
        this.ProductCompany = ProductCompany;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public double getOurPrice() {
        return OurPrice;
    }

    public void setOurPrice(double OurPrice) {
        this.OurPrice = OurPrice;
    }

    public int getTax() {
        return Tax;
    }

    public void setTax(int Tax) {
        this.Tax = Tax;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    private String ProductId;
    private String ProductName;
    private String ProductCompany;
    private double ProductPrice;
    private double OurPrice;
    private int Tax;
    private int Quantity;
    private double total;
}
