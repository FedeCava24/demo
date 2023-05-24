package com.example.demo.Service;

import com.example.demo.AdminPage;
import com.example.demo.DashboardPage;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.LogoutPage;
import com.example.demo.MainPage;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {

    }

    public static class AuthException extends Exception {

    }

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void authenticate(String username, String password) throws AuthException {
        User user = userRepository.getByUsername(username);
        if (user != null && user.checkPassword(password) && user.isActive()) {
            VaadinSession.getCurrent().setAttribute(User.class, user);
            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream().forEach(route ->
                RouteConfiguration.forSessionScope().setRoute(
                        route.route, route.view, DashboardPage.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("", "Home", MainPage.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutPage.class));

        } else if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("", "Home", MainPage.class));
            routes.add(new AuthorizedRoute("admin", "Admin", AdminPage.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutPage.class));
        }

        return routes;
    }

    public void register(String email, String password) {
        User user = userRepository.save(new User(email, password, Role.USER));
        System.out.println("http://localhost:8080/activate?code=" + user.getActivationCode());
    }

    public void activate(String activationCode) throws AuthException {
        User user = userRepository.getByActivationCode(activationCode);
        if (user != null) {
            user.setActive(true);
            userRepository.save(user);
        } else {
            throw new AuthException();
        }
    }

}
