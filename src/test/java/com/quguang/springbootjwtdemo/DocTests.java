package com.quguang.springbootjwtdemo;

import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DocTests {

	//	输出Ascii格式
	@Test
	public void generateAsciiDocs() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.build();

		Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("src/docs/asciidoc/generated"));
	}

	//	输出Markdown格式
	@Test
	public void generateMarkdownDocs() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.MARKDOWN)
				.build();

		Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("src/docs/markdown/generated"));
	}
	
	//	输出Confluence使用的格式
	@Test
	public void generateConfluenceDocs() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
				.build();

		Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("src/docs/confluence/generated"));
	}
	
	//	输出Ascii到单文件
	@Test
	public void generateAsciiDocsToFile() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.build();

		Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFile(Paths.get("src/docs/asciidoc/generated/all"));
	}

	/**
	 * 输出Markdown到单文件
	 * @throws Exception
	 */
	@Test
	public void generateMarkdownDocsToFile() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.MARKDOWN)
				.build();

		Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFile(Paths.get("src/docs/markdown/generated/docs"));
	}

}