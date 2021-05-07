package educanet;

import educanet.utils.FileUtils;
import org.lwjgl.opengl.GL33;

public class Shaders {
    private static final String vertexShaderSource = FileUtils.readFile("resources/matrix/shaders/vertex-shader.glsl");

    private static final String fragmentShaderSource = FileUtils.readFile("resources/matrix/shaders/fragment-shader.glsl");

    public static int vertexShaderId;
    public static int fragmentShaderId;
    public static int shaderProgramId;

    public static void initShaders() {
        vertexShaderId = GL33.glCreateShader(GL33.GL_VERTEX_SHADER);
        fragmentShaderId = GL33.glCreateShader(GL33.GL_FRAGMENT_SHADER);

        GL33.glShaderSource(vertexShaderId, vertexShaderSource);
        GL33.glCompileShader(vertexShaderId);

        System.out.println(GL33.glGetShaderInfoLog(vertexShaderId));

        GL33.glShaderSource(fragmentShaderId, fragmentShaderSource);
        GL33.glCompileShader(fragmentShaderId);

        System.out.println(GL33.glGetShaderInfoLog(fragmentShaderId));

        shaderProgramId = GL33.glCreateProgram();
        GL33.glAttachShader(shaderProgramId, vertexShaderId);
        GL33.glAttachShader(shaderProgramId, fragmentShaderId);
        GL33.glLinkProgram(shaderProgramId);

        System.out.println(GL33.glGetProgramInfoLog(shaderProgramId));

        GL33.glDeleteShader(vertexShaderId);
        GL33.glDeleteShader(fragmentShaderId);
    }

}
