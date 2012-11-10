package entidade;

import br.com.insula.opes.hibernate.usertype.ImmutableUserType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;

public class PlacaUserType extends ImmutableUserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }

    @Override
    public Class returnedClass() {
        return Placa.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] strings, Object o) throws HibernateException, SQLException {
        String value = rs.getString(strings[0]);
        if (rs.wasNull()) {
            return null;
        } else {
            return Placa.newInstance(value);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, Object o, int i) throws HibernateException, SQLException {
        if (o == null){
            ps.setNull(i, Types.VARCHAR);
        } else {
            Placa placa = (Placa) o;
            ps.setString(i, placa.getTexto());
        }
    }
    
}
