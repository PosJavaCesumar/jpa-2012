package entidade;

import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;

public class JpaTest {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpaPU");
    }

    @Test
    public void pessoa() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Fulano");
        pessoaFisica.setCpf("11122233344");
        entityManager.persist(pessoaFisica);

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setRazaoSocial("MONSTROS S.A.");
        pessoaJuridica.setCnpj("11222333000199");
        entityManager.persist(pessoaJuridica);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setTelefone("30302020");
        entityManager.persist(fornecedor);

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Fiesta");
        veiculo.setPlaca(Placa.newInstance("AOU-2482"));
        veiculo.setFornecedor(fornecedor);
        fornecedor.getVeiculos().add(veiculo);
        entityManager.persist(veiculo);
        
        pessoaFisica.getVeiculos().add(veiculo);
        veiculo.getPessoas().add(pessoaFisica);
        JPAQuery query = new JPAQuery(entityManager);
        QVeiculo qVeiculo = QVeiculo.veiculo;
        List<Veiculo> list = 
                query.from(qVeiculo).where(
                   qVeiculo.placa.eq(
                       Placa.newInstance("AOU-2482")
                   )
                ).orderBy(qVeiculo.modelo.asc()).list(qVeiculo);
        
        for (Veiculo veic: list) {
            System.out.println(veic.getPlaca());
        }

        entityManager.getTransaction().commit();
    }
}
