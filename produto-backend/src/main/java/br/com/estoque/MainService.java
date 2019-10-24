package br.com.estoque;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import br.com.estoque.dao.ProdutoDao;
import br.com.estoque.resources.ProdutoResource;

//import com.yammer.dropwizard.Service;
//import com.yammer.dropwizard.assets.AssetsBundle;
//import com.yammer.dropwizard.config.Bootstrap;
//import com.yammer.dropwizard.config.Environment;
//import com.yammer.dropwizard.db.DatabaseConfiguration;
//import com.yammer.dropwizard.jdbi.DBIFactory;
//import com.yammer.dropwizard.migrations.MigrationsBundle;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.paradoxical.dropwizard.swagger.AppSwaggerConfiguration;
import io.paradoxical.dropwizard.swagger.bundles.SwaggerUIBundle;


public class MainService extends Application<MainConfiguration> {

  public static void main(String[] args) throws Exception {
    new MainService().run(args);
  }

  @Override
  public void initialize(Bootstrap<MainConfiguration> bootstrap) {
	  
	    // enable swagger for application port
	    bootstrap.addBundle(
	        new SwaggerUIBundle(env -> {
	            return new AppSwaggerConfiguration(env) {
	                {
	                    setTitle("My API");
	                    setDescription("My API");
	                    // The package name to look for swagger resources under
	                    setResourcePackage(MainService.class.getPackage().getName());
	                    setLicense("Apache 2.0");
	                    setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
	                    setContact("admin@paradoxical.io");
	                    setVersion("1.0");
	                }
	            };
	        }));
	    
    bootstrap.addBundle(new MigrationsBundle<MainConfiguration>() {
      @Override
      public PooledDataSourceFactory getDataSourceFactory(final MainConfiguration configuration) {
        return configuration.getDataSourceFactory();
      }
    });
    bootstrap.addBundle(new AssetsBundle("/assets/"));
  }

  @Override
  public void run(MainConfiguration configuration, Environment environment) throws Exception {
    final DBIFactory factory = new DBIFactory();
    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
    final ProdutoDao dao = jdbi.onDemand(ProdutoDao.class);
    
 // Enable CORS headers
    final FilterRegistration.Dynamic cors =
        environment.servlets().addFilter("CORS", CrossOriginFilter.class);

    // Configure CORS parameters
    cors.setInitParameter("allowedOrigins", "*");
    cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
    cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

    // Add URL mapping
    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    environment.jersey().register(new ProdutoResource(dao));

  }

}
