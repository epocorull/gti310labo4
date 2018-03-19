package ca.ets.ConversionRGBversYCbCr;

public class ImageConvertion {
    private int[][][] imageInitiale;
    private int[][][] imageFinale;
    private boolean encode;

    public ImageConvertion(int[][][] image, boolean encode ) {
        this.imageInitiale = image;
        this.encode = encode;
    }

    public int[][][] getImageFinale() {
        return imageFinale;
    }

    public void ConvertirImage() {
        int height = imageInitiale[0].length;
        int width = imageInitiale[0][0].length;
        this.imageFinale = new int[3][height][width];
        for (int line = 0; line < height; line++) {
            for (int col = 0; col < width; col++) {
                int[] pix_ini = new int[3];
                pix_ini[0] = imageInitiale[0][line][col];
                pix_ini[1] = imageInitiale[1][line][col];
                pix_ini[2] = imageInitiale[2][line][col];
                ConversionRGBversYCbCr pixel = new ConversionRGBversYCbCr(pix_ini, encode);
                if (encode) {
                    pixel.EncodeVersYCbCr();
                    this.imageFinale[0][line][col] = pixel.getYCbCr()[0];
                    this.imageFinale[1][line][col] = pixel.getYCbCr()[1];
                    this.imageFinale[2][line][col] = pixel.getYCbCr()[2];
                }
                else {
                    pixel.DecodeVersRGB();
                    this.imageFinale[0][line][col] = pixel.getRGB()[0];
                    this.imageFinale[1][line][col] = pixel.getRGB()[1];
                    this.imageFinale[2][line][col] = pixel.getRGB()[2];
                }

            }
        }
    }

}
