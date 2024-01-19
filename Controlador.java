import java.util.HashMap;
import java.util.Map;

public class Controlador implements IRadio {
    private boolean isOn;
    private boolean isAM;
    private float currentFrequency;
    private Map<Integer, Float> favoriteFrequencies;

    public Controlador() {
        isOn = false;
        isAM = true;
        currentFrequency = 530.0f; // Inicializamos en la frecuencia AM más baja
        favoriteFrequencies = new HashMap<>();
    }

    @Override
    public boolean getState() {
        return isOn;
    }

    @Override
    public void tooglePowerOffOn() {
        isOn = !isOn;
        if (!isOn) {
            System.out.println("Radio apagado.");
        } else {
            System.out.println("Radio encendido.");
        }
    }

    @Override
    public void toogleAMFM() {
        isAM = !isAM;
        System.out.println("Cambió a modo " + (isAM ? "AM" : "FM"));
    }

    @Override
    public boolean getStateAMFM() {
        return isAM;
    }

    @Override
    public void nextFrequency() {
        if (isAM) {
            currentFrequency += 10.0f;
            if (currentFrequency > 1610.0f) {
                currentFrequency = 530.0f;
            }
        } else {
            currentFrequency += 0.2f;
            if (currentFrequency > 107.9f) {
                currentFrequency = 87.9f;
            }
        }
        System.out.println("Sintonizando a " + currentFrequency + (isAM ? " AM" : " FM"));
    }

    @Override
    public void previousFrequency() {
        if (isAM) {
            currentFrequency -= 10.0f;
            if (currentFrequency < 530.0f) {
                currentFrequency = 1610.0f;
            }
        } else {
            currentFrequency -= 0.2f;
            if (currentFrequency < 87.9f) {
                currentFrequency = 107.9f;
            }
        }
        System.out.println("Sintonizando a " + currentFrequency + (isAM ? " AM" : " FM"));
    }

    @Override
    public float getCurrentFrequency() {
        return currentFrequency;
    }

    @Override
    public void setFavFrequency(int button) {
        favoriteFrequencies.put(button, currentFrequency);
        System.out.println("Frecuencia guardada en el botón " + button);
    }

    @Override
    public float getFavFrequency(int button) {
        if (favoriteFrequencies.containsKey(button)) {
            return favoriteFrequencies.get(button);
        } else {
            System.out.println("No hay una frecuencia guardada en el botón " + button);
            return -1.0f;
        }
    }
}