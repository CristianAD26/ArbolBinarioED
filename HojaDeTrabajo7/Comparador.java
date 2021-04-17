//Cristian Eduardo Aguirre Duarte
//Carne 20231
//Algoritmos y estructura de datos
//Hoja de trabajo 7

public class Comparador implements Comparable<Comparador>{
    String ingles;
    String frances;
    String espanol;
    String u;

    public Comparador(String ingles, String frances, String espanol){
        this.ingles=ingles;
        this.frances=frances;
        this.espanol=espanol;
    }

    public Comparador(String u){
        this.u = u;
    }

    public String getWord(String key){
        if(u == null) {
            if (key.equals("Ingles")) {
                return ingles;
            } else if (key.equals("Frances")) {
                return frances;
            } else if (key.equals("Espanol")) {
                return espanol;
            } else return null;
        } else {
            return u;
        }
    }

    @Override
    public int compareTo(Comparador o) {
        if(o.getU() == null){
            return getWord(Main.Idioma).compareTo(o.getWord(Main.Idioma));
        } else {
            return getWord(Main.Idioma).compareTo(o.getU());
        }

    }

    public String getU(){
        return u;
    }

    @Override
    public String toString() {
        return "( " +ingles + ", " +frances + ", " +espanol+" )\n";
    }
}


