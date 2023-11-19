//В этом классе я пишу алгоритм для вывода json файла. Еще буду дорабатывать, разбивая файл на более мелкие объекты,
// чтобы в конце дойти до расписания на день, чтобы затем суметь выводить нужное мне расписание, задавая курс,
// группу, неделю и день. Так как это на данный момент самый "сложный" класс, я расписала его более подробно (см. ниже)


//тут весь импорт
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;


public class JsonParser { //создала класс
    public Root root_parse(){ //создала метод для парсинга

        Root root = new Root(); //создала экземпляр класса Root

        JSONParser parser = new JSONParser(); //создала экземпляр класса JSONParser

        try(FileReader reader = new FileReader("target/Shedule.json")) { //создаю try catch для обработки исключений
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader); //вызываю метод parse из добавленной бибилиотеки для работы с json

            String name = (String) rootJsonObject.get("name"); //инициализирую переменную и задаю ей значение из класса Root
            JSONArray shedJsonArray = (JSONArray) rootJsonObject.get("shed"); //аналогично, только для массива

            List<Shed> shedList = new ArrayList<>(); //созжаю список
            for(Object it: shedJsonArray){ //в цикле пробегаюсь по заданному массиву
                JSONObject shedJsonObject = (JSONObject) it; //инициализирую объект из shedJsonArray и задаю его

                long course = (Long) shedJsonObject.get("course"); //иниицализация, присвоение значения. Тип long,так как int выдаст ошибку.
                //^ мы приобразуем лонг в инт позже
                List<Group> group = (List<Group>) shedJsonObject.get("group"); //ну тут как выше, только для списка

                Shed shed = new Shed((int) course, group); //создаем экземпляр класса, куда сразу помещаем курс и группу
                //с группой нужно будет поработать позже, перед третьей аттестацией

                shedList.add(shed); //добавляем shed в shedlist
            }

            root.setName(name); //устанавливаем имя (оно будет = "Расписание занятий")
            root.setShed(shedList); //и расписание
            return root; //и возвращаем root
        } catch (Exception e) { //если что-то пойдет не так, печатаем, что парсинг прошел неудачно
            System.out.println("Parsing error" + e.toString());
        }

        return null; //и возвращаем null, если что-то пошло не так
    }

    /*public Shed shed_parse(){ //дальше я думаю, как распарсить всё остальное, но это смотреть не нужно
        Shed shed = new Shed();

        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("target/Shedule.json")) {
            JSONObject shedJsonObject = (JSONObject) parser.parse(reader);

            long course = (Long) shedJsonObject.get("course");
            JSONArray groupJsonArray = (JSONArray) shedJsonObject.get("group");

            List<Group> groupList = new ArrayList<>();
            for(Object it: groupJsonArray){
                JSONObject groupJsonObject = (JSONObject) it;

                long group = (Long) groupJsonObject.get("group");
                List<Shedule> shedule = (List<Shedule>) groupJsonObject.get("shedule");

                Group group0 = new Group((int) group, shedule);

                groupList.add(group0);
            }

            shed.setCourse((int) course);
            shed.setGroup(groupList);
            return shed;
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }





        return null;
    }*/
}
