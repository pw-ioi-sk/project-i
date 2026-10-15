package org.example.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.util.HibernateUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Map;

@WebListener
public class ThymeleafConfig implements ServletContextListener {

    private static TemplateEngine templateEngine;
    private static JakartaServletWebApplication application;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        application = JakartaServletWebApplication.buildApplication(sce.getServletContext());
        WebApplicationTemplateResolver resolver = new WebApplicationTemplateResolver(application);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        HibernateUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.shutdown();
    }

    public static void render(HttpServletRequest req,
                              HttpServletResponse res,
                              Map<String,Object> variables,
                              String templateName)
            throws IOException {
        IWebExchange exchange = application.buildExchange(req, res);
        WebContext webContext = new WebContext(exchange, res.getLocale());
        webContext.setVariables(variables);
        templateEngine.process(templateName, webContext, res.getWriter());
    }
}
