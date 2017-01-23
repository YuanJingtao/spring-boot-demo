package com.example;

import com.example.config.DataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Import(DataSourceConfig.class)
public class DemoApplication {
	
	private static final String[] BANNER = { "", "  .   ____          _            __ _ _", " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\", "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\", " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )", "  '  |____| .__|_| |_|_| |_\\__, | / / / /", " =========|_|==============|___/=/_/_/_/" };
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);



	//对于Java 8来说可以用lambda表达式,而不需要创建该接口的一个实例.
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		return (ConfigurableEmbeddedServletContainer container) -> {
			container.setSessionTimeout(5, TimeUnit.SECONDS);
		};
	}

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		
		SpringApplication bootstrap = new  SpringApplication(DemoApplication.class);
		bootstrap.setBanner(new Banner() {
			
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
				// print banner in our console

				for (String line : BANNER) {
					printStream.println(line);
				}
				String version = SpringBootVersion.getVersion();
				version = " (v" + version + ")";
				String padding = "";
				while (padding.length() < 42 - (version.length() + " :: Spring Boot :: ".length())) {
					padding = padding + " ";
				}
				printStream.println(AnsiOutput.toString(new Object[] { AnsiColor.GREEN, " :: Spring Boot :: ", AnsiColor.DEFAULT, padding, AnsiStyle.FAINT, version }));
				printStream.println();
				logger.info("print banner");
			}
		});
		bootstrap.setBannerMode(Banner.Mode.CONSOLE);
		bootstrap.run(args);
	}
}
