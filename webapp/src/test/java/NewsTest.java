import com.kk.models.NewsEntity;
import com.kk.service.IHibernateCRUD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class NewsTest {
    @Autowired
    private IHibernateCRUD hibernateCRUD;

    /*   private ApplicationContext ctx = null;

       {
           ctx = new ClassPathXmlApplicationContext("spring-dao.xml");
       }
   */
/*    @Test
public void testSource(){
    DataSource dataSource = (DataSource)ctx.getBean("dataSource");
    try {
        System.out.println("1312"+dataSource.getConnection());
    } catch (SQLException e) {
        e.printStackTrace();
    }
}*/
    @Test
    public void testInsert() {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setId(3);
        newsEntity.setAuthor("kkk");
        newsEntity.setContent("sss");
        newsEntity.setTitle("ss");
        hibernateCRUD.insert(newsEntity);
    }

    @Test
    public void delete() {
        hibernateCRUD.delete(1);
    }

    @Test
    public void testSelect() {
        System.out.println(hibernateCRUD.select(1));
    }

}  