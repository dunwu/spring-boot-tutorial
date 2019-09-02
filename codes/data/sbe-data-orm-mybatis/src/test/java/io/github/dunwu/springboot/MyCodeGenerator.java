package io.github.dunwu.springboot;

import io.github.dunwu.generator.DefaultCodeGenerator;

/**
 * 代码生成器
 *
 * @author Zhang Peng
 * @since 2019-04-15
 */
public class MyCodeGenerator extends DefaultCodeGenerator {
    public static void main(String[] args) {
        new MyCodeGenerator().generate();
    }
}
