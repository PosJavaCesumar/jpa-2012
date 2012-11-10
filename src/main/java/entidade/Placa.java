package entidade;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;

public class Placa implements Serializable {
    
    final String letras;
    
    final String numeros;
    
    private Placa(String letras, String numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }
    
    public static Placa newInstance(String placa) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(placa));
        Preconditions.checkArgument(
                placa.matches("[A-Z]{3}-\\d{4}"));
        String[] split = placa.split("-");
        return new Placa(split[0], split[1]);
    }

    public String getTexto() {
        return String.format("%s-%s", letras, numeros);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).
                add("letras", letras).
                add("numeros", numeros).toString();
    }
    
}