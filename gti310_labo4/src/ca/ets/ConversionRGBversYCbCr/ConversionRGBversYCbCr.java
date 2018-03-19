package ca.ets.ConversionRGBversYCbCr;

public class ConversionRGBversYCbCr {
    private int[] RGB;
    private int[] YCbCr;

    ConversionRGBversYCbCr(int[] pixel, boolean encode) {
        if (encode) {
            this.RGB = pixel;
            this.YCbCr = new int[3];
        }
        else {
            this.YCbCr = pixel;
            this.RGB = new int[3];
        }
    }

    public void EncodeVersYCbCr() {
        this.YCbCr[0] = (short) (0.299*this.RGB[0] + 0.587*this.RGB[1] + 0.114*this.RGB[2]);
        this.YCbCr[1] = (short) ( -0.168736*this.RGB[0] + -0.331264*this.RGB[1] + 0.5*this.RGB[2] + 0.5);
        this.YCbCr[0] = (short) ( 0.5*this.RGB[0] + -0.418688*this.RGB[1] + -0.081312*this.RGB[2] + 0.5);
    }

    public void DecodeVersRGB() {
        this.RGB[0] = (short) (this.YCbCr[0] + 1.4020*this.YCbCr[3]);
        this.RGB[1] = (short) (this.YCbCr[0] - 0.3441357*this.YCbCr[1] - 0.7141362*this.YCbCr[3] -0.5);
        this.RGB[2] = (short) (this.YCbCr[0] + 1.772*this.YCbCr[1] - 0.5);
    }

    public int[] getYCbCr() {
        return YCbCr;
    }

    public int[] getRGB() {
        return RGB;
    }
}
