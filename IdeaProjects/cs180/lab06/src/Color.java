public class Color {
    /* TODO: Implement Color.java */
    private int red, green, blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public String getHex() {
        /*
        * For this function, you will need to call intToHex with each of the three colors and 
        * return a string formatted as follows: "# + redHexValue + greenHexValue + blueHexValue"
        *
        * Note: The "+" symbol is only shown above to illustrate that each of the values will be 
        * concatenated into a single string. It should NOT be in your final result. 
        */
        String s = "#" + intToHex(getRed()) + "" + intToHex(getGreen()) + "" + intToHex(getBlue());

        return s;
    }

    public String intToHex(int value) {
        int num = value;
        if (num == 0) {
            return "00";
        }

        int remain;
        StringBuilder hex = new StringBuilder();
        while (num > 0) {
            remain = num % 16;
            if (remain < 10) {
                hex.append(remain);
            }
            else {
                switch (remain) {
                    case 10: {
                        hex.append("A");
                        break;
                    }
                    case 11: {
                        hex.append("B");
                        break;
                    }
                    case 12: {
                        hex.append("C");
                        break;
                    }
                    case 13: {
                        hex.append("D");
                        break;
                    }
                    case 14: {
                        hex.append("E");
                        break;
                    }
                    case 15: {
                        hex.append("F");
                        break;
                    }
                }
            }
            if (value < 16) {
                hex.append("0");
            }
            num /= 16;
        }
        hex.reverse();

        return hex.toString();
    }
}
