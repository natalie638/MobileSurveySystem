package MobileSurveySytem.MobileSurveySystem;

public class Question {
    private String question;
    private int options;

    public Question(String q1, int o){
        question = q1;
        options = o;
    }

    public String getQuestion(){
        return question;
    }

    public int getOptions(){
        return options;
    }
}
