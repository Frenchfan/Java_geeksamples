package OOPLecture5.Task3.Core.Presenters;

 
import OOPLecture5.Task3.Core.Infrastructure.Generator;
import OOPLecture5.Task3.Core.Models.Model;
import OOPLecture5.Task3.Core.Views.View;
import OOPLecture5.Task3.Mathematics.Exceptions.UnacceptableValueException;
import OOPLecture5.Task3.Mathematics.Shapes.Circle;
import OOPLecture5.Task3.Mathematics.Shapes.Rectangle;
import OOPLecture5.Task3.Mathematics.Shapes.Shape;


public class Presenter {
    Model model;
    View view;

    public Presenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    public void append() throws UnacceptableValueException {
        view.set("1 - Circle, 2 - Rectangle");
        String response = view.get();
        Shape figure;

        switch (response) {
            case "1":
                figure = Circle.create(Generator.number(), "Circle_" + Generator.number());
                break;
            default:
                figure = Rectangle.create(
                    Generator.number(),
                    Generator.number(),
                    "Rectangle_" + Generator.number());
                break;
        }

        model.append(figure);
        view.set("ok");

    }

    public void show() {
        view.set(model.show());
    }

    public void showArea()
        {
            view.set(String.format("all Area %s", model.area()));
        }
}
