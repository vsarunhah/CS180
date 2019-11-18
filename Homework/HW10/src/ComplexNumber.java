import java.text.DecimalFormat;

/**
 * @author varun
 * @version 1.0
 */
public final class ComplexNumber implements Comparable<ComplexNumber> {
    private double im;
    private double re;

    public ComplexNumber() {
        this.im = 0;
        this.re = 0;
    }

    public ComplexNumber(double re, double im) {
        this.im = im;
        this.re = re;
    }

    public ComplexNumber(ComplexNumber c) throws IllegalArgumentException {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        this.im = c.getIm();
        this.re = c.getRe();
    }

    public synchronized double getIm() {
        return im;
    }

    public synchronized void setIm(double im) {
        this.im = im;
    }

    public synchronized double getRe() {
        return re;
    }

    public synchronized void setRe(double re) {
        this.re = re;
    }

    public synchronized ComplexNumber conjugate() {
        return new ComplexNumber(getRe(), -getIm());
    }

    public synchronized ComplexNumber reciprocal() {
        double a = this.getRe();
        double b = this.getIm();
        double v = Math.pow(a, 2) + Math.pow(b, 2);
        return new ComplexNumber((a / v), -(b / v));
    }

    public synchronized ComplexNumber add(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        return new ComplexNumber(this.getRe() + complexNumber.getRe(), this.getIm() + complexNumber.getIm());
    }

    public synchronized ComplexNumber subtract(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        return new ComplexNumber(this.getRe() - complexNumber.getRe(), this.getIm() - complexNumber.getIm());
    }

    public synchronized ComplexNumber multiply(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        double a = getRe();
        double b = getIm();
        double c = complexNumber.getRe();
        double d = complexNumber.getIm();
        return new ComplexNumber(a * c - b * d, b * c + a * d);
    }

    public synchronized ComplexNumber divide(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        double a = getRe();
        double b = getIm();
        double c = complexNumber.getRe();
        double d = complexNumber.getIm();
        double v = Math.pow(c, 2) + Math.pow(d, 2);
        return new ComplexNumber(((a * c + b * d) / v), ((b * c - a * d) / v));
    }

    @Override
    public synchronized int compareTo(ComplexNumber o) {
        if (o == null) {
            return -1;
        }
        if (o.getRe() < getRe()) {
            return 1;
        } else if (o.getRe() > getRe()) {
            return -1;
        }
        if (o.getIm() < getIm()) {
            return 1;
        } else if (o.getIm() > getIm()) {
            return -1;
        }
        return 0;
    }

    @Override
    public synchronized boolean equals(Object object) {
        if (object instanceof ComplexNumber) {
            ComplexNumber c = (ComplexNumber) object;
            return compareTo(c) == 0;
        }
        return false;
    }

    @Override
    public synchronized String toString() {
        DecimalFormat df = new DecimalFormat("#0.000000");
        if (getIm() < 0) {
            return df.format(getRe()) + " - " + df.format(-1 * getIm()) + "i";
        }
        return df.format(getRe()) + " + " + df.format(getIm()) + "i";
    }

}
