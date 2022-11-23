/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainModel.NhanVien;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.NhanVienResponse;

/**
 *
 * @author congh
 */
public class NhanVienRepository extends CrudRepository<UUID, NhanVien, NhanVienResponse> {

    private final static String emailGui = "conghuy29062003@gmail.com";
    private final static String matKhau = "nllbsvmsqpoiimpe";

    public NhanVienRepository() {
        className = NhanVien.class.getName();
        res = " new viewModel.NhanVienResponse (a.id, a.ma,a.hoVaTen, a.gioiTinh, a.ngaySinh, a.email , a.hinhAnh, a.chucVu,a.diaChi , a.sdt, a.matKhau, a.trangThai)";
    }

    public String guiMail(String emailNhan,
            String tieuDe, String noiDung)
            throws AddressException, MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailGui, matKhau);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailGui));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(emailNhan));

        // Tiêu đề
        message.setSubject(tieuDe);

        // Nội dung
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(noiDung, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
        return noiDung;
    }
}
