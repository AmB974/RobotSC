/*
 * Creative commons CC BY-NC-SA 2020 Yvan Maillot <yvan.maillot@uha.fr>
 *
 *     Share - You can copy and redistribute the material in any medium or format
 * 
 *     Adapt - You can remix, transform, and build upon the material 
 * 
 * Under the following terms :
 * 
 *     Attribution - You must give appropriate credit, provide a link to the license, 
 *     and indicate if changes were made. You may do so in any reasonable manner, 
 *     but not in any way that suggests the licensor endorses you or your use. 
 * 
 *     NonCommercial — You may not use the material for commercial purposes. 
 * 
 *     ShareAlike — If you remix, transform, or build upon the material, 
 *     you must distribute your contributions under the same license as the original. 
 * 
 * Notices:    You do not have to comply with the license for elements of 
 *             the material in the public domain or where your use is permitted 
 *             by an applicable exception or limitation. 
 * 
 * No warranties are given. The license may not give you all of the permissions 
 * necessary for your intended use. For example, other rights such as publicity, 
 * privacy, or moral rights may limit how you use the material. 
 * 
 * See <https://creativecommons.org/licenses/by-nc-sa/4.0/>.
 */

package instruction;

import java.util.Scanner;
import javax.swing.ImageIcon;
import robot.DansLeMur;
import robot.TropDePas;

/**
 *
 * @author Yvan
 */
public class Bloc extends InstructionComposee {
    private static final long serialVersionUID = 1L;
    
    public Bloc(String nom) {        
        Scanner sc = new Scanner(nom);
        sc.useDelimiter(", ");
        this.nom = sc.next();
        while(sc.hasNext()) {
            String var = sc.next();
            if (set(var, 0) == null)
                this.nom += ", " + var;
        }
    }
    
    public Bloc() {
        this("bloc");
    }

    @Override
    public void go(robot.Robot robot) throws DansLeMur, InterruptedException, TropDePas {
        for(int i = 0; i < getChildCount(); i++) {
            Instruction I = (Instruction) getChildAt(i);
          
                I.go(robot);
           
        }
    }


    /*@Override
    public void set(Object o) {
    }*/

    @Override
    public boolean autorisationAjout() {
        return true;
    }

    @Override
    public ImageIcon getIcon() {
        return null; 
    }



}
