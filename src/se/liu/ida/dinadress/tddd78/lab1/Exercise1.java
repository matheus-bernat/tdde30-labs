package se.liu.ida.dinadress.tddd78.lab1;

import java.util.ArrayList;
import java.util.List;

public class Exercise1
{
    public static void main(String[] args) {
	System.out.println("Hello world");
	List<String> myList = new ArrayList<String>();
	myList.add("foo");
	myList.add("whatup dude");
	myList.add("tja");
	for (String s : myList) {
	    System.out.println(s);

	}
    }
}
/*
//////////////////////////////// DÚVIDAS /////////////////////////////////////////
- hur är fallingX o fallingY kopplade till falling? hur ändrar vi positionen på falling när vi bara ändrar på fallinX/Y t.ex?

4) förstår inte helt vad de här listeners gör (addListeners, notifyListeners, addBoardListener, ...)
-obs: alla metoder som ändrar på speltillståndet ska anropa notifyListeners()
/////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////// SVAR /////////////////////////////////////////
- textComponent.paintComponent(); SVAR: behöver ej anropas, sker automagically

3) where should I have the key binding code?
-i tick() tror jag. FEL! du vill att det ska ba anropas en enda gång. Om den vore i tick()
så skulle det anropas varje gång klockan slog.
-det ska va i TetrisComponents konstruktor!

2) förstår inte det här med getActionMap() getInputMap()? Vad är parent?
-obs: "getActionMap returns the ActionMap containg the key/action bindings"
-obs: "getImputMap returns the InputMap used when the component has focus".

"SquareType[][] squares" -> does it mean that the things withing thr brackets ned to be a component of the SquareType enum? YES

ska inte vi sätta fallingX till nåt värde? över vänstra hörn? SVAR: kolla i konstruktorn
OBS! fallingX o fallingY har som 0,0 övre vänstrahärnet i BOARDS koord.systemet, ej figurens

hur ska jga ersätta det som finns i squares nu? Ska jag ändra i konstruktorn?om jag gör utanför konstruktorn, hur gör jag då? Hur ska jag ändra på grejersom finns inuti konstruktorn?
SVAR:: kör konstruktorn på test, och sen anropa metoden "squareAdder()"
/////////////////////////////////////////////////////////////////////////////////////////////
 */


