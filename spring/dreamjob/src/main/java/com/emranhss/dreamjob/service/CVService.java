package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.*;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class CVService {

//    @Autowired
//    private JobSeekerRepository jobSeekerRepository;

//    public byte[] generateCV(Long jobSeekerId) throws Exception {
//        JobSeeker js = jobSeekerRepository.findById(jobSeekerId)
//                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(out);
//        PdfDocument pdfDoc = new PdfDocument(writer);
//        Document document = new Document(pdfDoc);
//
//        // Profile Photo
//        if (js.getPhoto() != null && !js.getPhoto().isEmpty()) {
//            try {
//                String imagePath = "uploads/jobseekers/" + js.getPhoto();
//                Image profilePic = new Image(ImageDataFactory.create(imagePath));
//                profilePic.setWidth(100);
//                profilePic.setHeight(100);
//                profilePic.setAutoScale(true);
//                profilePic.setMarginBottom(10);
//                profilePic.setHorizontalAlignment(HorizontalAlignment.CENTER);
//                document.add(profilePic);
//            } catch (Exception e) {
//                System.out.println("Image not found: " + js.getPhoto());
//            }
//        }
//
//        // Personal Info
//        document.add(new Paragraph(js.getName())
//                .setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER));
//        document.add(new Paragraph(js.getEmail() + " | " + js.getPhone() + " | " + js.getGender())
//                .setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.GRAY));
//        document.add(new Paragraph("Address: " + js.getAddress())
//                .setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.GRAY));
//        document.add(new Paragraph("Date of Birth: " + js.getDateOfBirth())
//                .setFontSize(10).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.GRAY));
//        document.add(new Paragraph("\n"));
//
//        // Education Table
//        if (!js.getEducations().isEmpty()) {
//            document.add(new Paragraph("Education").setBold().setFontSize(14).setFontColor(ColorConstants.BLUE));
//            Table eduTable = new Table(UnitValue.createPercentArray(new float[]{2,3,2,2,2})).useAllAvailableWidth();
//            String[] headers = {"Level", "Institute", "Board", "Result", "Year"};
//            for (String h : headers) eduTable.addHeaderCell(new Cell().add(new Paragraph(h)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//            for (Education edu : js.getEducations()) {
//                eduTable.addCell(edu.getLevel());
//                eduTable.addCell(edu.getInstitute());
//                eduTable.addCell(edu.getBoard());
//                eduTable.addCell(edu.getResult());
//                eduTable.addCell(edu.getYear());
//            }
//            document.add(eduTable);
//            document.add(new Paragraph("\n"));
//        }
//
//        // Experience Table
//        if (!js.getExperiences().isEmpty()) {
//            document.add(new Paragraph("Experience").setBold().setFontSize(14).setFontColor(ColorConstants.BLUE));
//            Table expTable = new Table(UnitValue.createPercentArray(new float[]{2,2,2,2,3})).useAllAvailableWidth();
//            String[] headers = {"Position", "Company", "From", "To", "Description"};
//            for (String h : headers) expTable.addHeaderCell(new Cell().add(new Paragraph(h)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
//            for (Experience exp : js.getExperiences()) {
//                expTable.addCell(exp.getPosition());
//                expTable.addCell(exp.getCompany());
//                expTable.addCell(exp.getFromDate()!=null? exp.getFromDate().toString():"");
//                expTable.addCell(exp.getToDate()!=null? exp.getToDate().toString():"Present");
//                expTable.addCell(exp.getDescription());
//            }
//            document.add(expTable);
//            document.add(new Paragraph("\n"));
//        }
//
//        // TODO: Add Training, Skills, Languages, Extracurricular, Hobbies, References
//        // সব previous code 그대로 use করা যাবে
//
//        document.add(new Paragraph("Generated by DreamJob Portal")
//                .setFontSize(8).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.GRAY));
//
//        document.close();
//        return out.toByteArray();
//    }



//    @Transactional // important for lazy loading
//    public byte[] generateCVForUser(String email) throws Exception {
//        JobSeeker js = jobSeekerRepository.findByUserEmail(email)
//                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));
//
//        // Force initialization of collections
//        js.getEducations().size();
//        js.getExperiences().size();
//        js.getTrainings().size();
//        js.getSkills().size();
//        js.getLanguages().size();
//        js.getExtracurriculars().size();
//        js.getHobbies().size();
//        js.getReferences().size();
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(out);
//        PdfDocument pdfDoc = new PdfDocument(writer);
//        Document document = new Document(pdfDoc);
//
//        // --- PDF generation code stays the same ---
//        // You can reuse your current logic for adding profile, education, experience, etc.
//
//        document.close();
//        return out.toByteArray();
//    }
}
