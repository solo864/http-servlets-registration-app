package servlet;

import dto.CreateUserDto;
import exception.ValidationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Gender;
import model.Role;
import service.UserService;
import util.JspHelper;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        req.getRequestDispatcher(JspHelper.get("registration"))
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserDto userDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .email(req.getParameter("email"))
                .birthday(req.getParameter("birthday"))
                .password(req.getParameter("password"))
                .build();
        try {
            userService.saveUser(userDto);
            resp.sendRedirect("/login");
        } catch (ValidationException ex) {
            req.setAttribute("errors", ex.getErrors());
            doGet(req, resp);
        }

    }
}
