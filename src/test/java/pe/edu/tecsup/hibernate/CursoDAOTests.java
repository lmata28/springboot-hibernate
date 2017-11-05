package pe.edu.tecsup.hibernate;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;

    @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getNombre());
        }
        Assert.assertTrue(cursos.size() > 0);
    }

  // @Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(5l);
        System.out.println("Filtrando el id 5");
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 5l);
    }

    //@Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setCodigo("001");
        curso.setNombre("Lenguage");
        curso.setFechaInicio(new Date());
        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(2l);
        curso.setCodigo("999");
        curso.setNombre("Curso Modificado");
        curso.setFechaInicio(new Date());

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(2l).getCodigo().equals("999"));
    }

   //@Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(2l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(2l) == null);
    }

}
