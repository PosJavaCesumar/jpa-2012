//package-info.java
@TypeDefs({
    @TypeDef(name="placa", 
            typeClass=PlacaUserType.class, 
            defaultForType=Placa.class)
})
package entidade;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;