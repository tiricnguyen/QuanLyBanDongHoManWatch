package utillies;


import domainModel.ChatLieuMatKinh;
import domainModel.ChatLieuVo;
import domainModel.HangDongHo;
import domainModel.LoaiDongHo;
import domainModel.MatDongHo;
import domainModel.NangLuongSuDung;
import domainModel.SanPham;
import domainModel.ChatLieuDay;
import domainModel.ChiTietSanPham;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory FACTORY;
    private static Session SESSION;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_QUANLYBANDONGHO_ManWatch");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
//        properties.put(Environment.HBM2DDL_AUTO, "create");//gen DB tự động

        conf.addAnnotatedClass(ChatLieuDay.class);
        conf.addAnnotatedClass(ChatLieuMatKinh.class);
        conf.addAnnotatedClass(ChatLieuVo.class);
        conf.addAnnotatedClass(HangDongHo.class);
        conf.addAnnotatedClass(LoaiDongHo.class);
        conf.addAnnotatedClass(MatDongHo.class);
        conf.addAnnotatedClass(NangLuongSuDung.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.setProperties(properties);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static Session getSession() {
        if (SESSION == null || !SESSION.isConnected()) {
            SESSION = FACTORY.openSession();
        }
        return SESSION;
    }

    public static void main(String[] args) {
        if (SESSION == null) {
            System.out.println("Thành Công");
        }
    }

}
