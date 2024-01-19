import java.util.Scanner;
public class Controlador implements IRadio{
    Radio radiomain = new Radio(false, 87.2F, true);

    public Controlador() {
    }

    public void On() {

    }

    @Override
    public boolean getState() {
        return radiomain.isPower();
    }

    @Override
    public void tooglePowerOffOn() {
        int x = 0;
        if (radiomain.isPower() == false){
            radiomain.setPower(true);
            x = 1;
        }
        if (x == 0){
            if (radiomain.isPower() == true){
                radiomain.setPower(false);
                x = 1;
            }
        }
    }

    @Override
    public void toogleAMFM() {

    }

    @Override
    public boolean getStateAMFM() {
        return radiomain.isFrecuencia();
    }

    @Override
    public void nextFrequency() {
        if (radiomain.getEmisora() < 108.0) {
            float r = radiomain.getEmisora();
            r = r + 0.2F;
            r = Math.round(r * 10.0F) / 10.0F;
            radiomain.setEmisora(r);
        } else if (radiomain.getEmisora() == 108.0) {
            radiomain.setEmisora(87.2F);
        }
    }


    @Override
    public void previousFrequency() {
        if (radiomain.getEmisora() > 87.2) {
            float r = radiomain.getEmisora();
            r = r - 0.2F;
            r = Math.round(r * 10.0F) / 10.0F;
            radiomain.setEmisora(r);
        } else if (radiomain.getEmisora() == 87.2F) {
            radiomain.setEmisora(108.0F);
        }
    }


    @Override
    public float getCurrentFrequency() {
        return radiomain.getEmisora();
    }

    @Override
    public void setFavFrequency(int button) {

    }

    @Override
    public float getFavFrequency(int button) {
        return 0;
    }
}
