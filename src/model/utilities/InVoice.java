package model.utilities;

public class InVoice {

    private double basicPayment;
    private double tax;

    public InVoice() {
    }

    public InVoice(double basicPayment, double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment(){
        return getBasicPayment() + getTax();
    }
}
