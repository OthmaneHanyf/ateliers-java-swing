package atelier23.Views;

import atelier23.Models.StudentModel;
import org.w3c.dom.events.EventListener;

import java.awt.event.ActionListener;

public interface IStudentView {

    boolean isSuccess = false;
    String message = null;

    ActionListener createStudentHandler();

    ActionListener clearStudentsHandler();
    ActionListener quitHandler();

}
