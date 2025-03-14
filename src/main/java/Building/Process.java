package Building;

public class Process implements Construction{
    private List list = new List();
    @Override
    public void build(){
        do {
            try {
                list.updateStatus();
                list.next();
            } catch (Deviation e) {
                if (list.current.name == "Project") {
                    System.out.println("Rejected");
                    break;
                } else {
                    list.prev();
                }
            }
        }while (list.current.name != "Finishing");
    }

    @Override
    public void doneBuild() {
        System.out.println("Стройка завершена. ");
    }
}