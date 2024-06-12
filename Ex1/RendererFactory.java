/** 
 * creates a renderer based on the type and size
 */
public class RendererFactory {
    RendererFactory() {
    }
/**
 * creates a renderer based on the type and size
 * @param type string type of renderer, console or none
 * @param size int size of the renderer
 * @return the renderer object
 */
    public Renderer buildRenderer(String type, int size) {
        return switch (type) {
            case "console" -> new ConsoleRenderer(size);
            case "none" -> new VoidRenderer();
            default -> null;
        };
    }

}