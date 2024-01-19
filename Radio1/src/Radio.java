public class Radio {
    boolean power;
    double emisora;
    String frecuencia;

    public Radio() {
    }

    public Radio(boolean power, double emisora, String frecuencia) {
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public double getEmisora() {
        return emisora;
    }

    public void setEmisora(double emisora) {
        this.emisora = emisora;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }
}
