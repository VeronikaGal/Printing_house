package com.galeeva.project.servlet;

import com.galeeva.project.service.OrderDataService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/orders")
public class OrderDataServlet extends HttpServlet {

    private final OrderDataService orderDataService = OrderDataService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long serviceId = Long.valueOf(req.getParameter("serviceId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1>Заказанные услуги:</h1>");
            printWriter.write("<ul>");
            orderDataService.findAllByServiceid(serviceId).forEach(orderDataDto -> printWriter.write("""
                    <li>
                      %s - %s - %s
                    </li>
                    """.formatted(orderDataDto.getFile(),
                    orderDataDto.getStatus(), orderDataDto.getDelivery())));
            printWriter.write("</ul>");
        }
    }
}

