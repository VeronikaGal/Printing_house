package com.galeeva.project.servlet;

import com.galeeva.project.service.ServiceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/services")
public class ServiceServlet extends HttpServlet {

    private final ServiceService serviceService = ServiceService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список услуг:</h1>");
            printWriter.write("<ul>");
            serviceService.findAll().forEach(serviceDto -> {
                printWriter.write("""
                        <li>
                        <a href="/orders?serviceId=%d">%s</a>
                        </li>
                        """.formatted(serviceDto.getId(), serviceDto.getDescription()));
            });
            printWriter.write("</ul>");
        }
    }
}


