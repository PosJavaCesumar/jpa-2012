package entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType= DiscriminatorType.STRING, name="tipo", length=1)
public abstract class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    Integer version;
    
    @Embedded
    private Endereco endereco = new Endereco();
    
    @ManyToMany
    @JoinTable(name="pessoa_veiculo", 
            joinColumns=@JoinColumn(name="pessoa_fk"),
            inverseJoinColumns=@JoinColumn(name="veiculo_fk"))
    private List<Veiculo> veiculos = new LinkedList<Veiculo>();

    public Long getId() {
        return id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

}
