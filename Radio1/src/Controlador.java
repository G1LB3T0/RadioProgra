public class Controlador implements IRadio{
    Radio fm = new Radio(false, 90.2, "FM");

    public Controlador() {
    }

    public void On() {

    }

    @Override
    public boolean getState() {
        return false;
    }

    @Override
    public void tooglePowerOffOn() {

    }

    @Override
    public void toogleAMFM() {

    }

    @Override
    public boolean getStateAMFM() {
        return false;
    }

    @Override
    public void nextFrequency() {

    }

    @Override
    public void previousFrequency() {

    }

    @Override
    public float getCurrentFrequency() {
        return 0;
    }

    @Override
    public void setFavFrequency(int button) {

    }

    @Override
    public float getFavFrequency(int button) {
        return 0;
    }
}
