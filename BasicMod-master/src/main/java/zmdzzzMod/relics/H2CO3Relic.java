package zmdzzzMod.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.ObtainPotionEffect;
import zmdzzzMod.character.zmd;
import zmdzzzMod.potions.ColaPotion;

import static zmdzzzMod.BasicMod.makeID;

public class H2CO3Relic extends BaseRelic {
    private static final String NAME = "H2CO3Relic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.BOSS; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.
//    public static int cnt = 0;

    private static final int STRENGTH = 10; //For convenience of changing it later and clearly knowing what the number means instead of just having a 10 sitting around in the code.

    public H2CO3Relic() {
        super(ID, NAME, zmd.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void onUsePotion() {
        /* 41 */     if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
            /* 42 */       for (int i = 0; i < AbstractDungeon.player.potionSlots; i++) {
                /* 43 */         addToBot((AbstractGameAction)new ObtainPotionAction(new ColaPotion()));
                /*    */       }
            /*    */     }
        /* 46 */     else if (AbstractDungeon.player.hasRelic("Sozu")) {
            /* 47 */       AbstractDungeon.player.getRelic("Sozu").flash();
            /*    */     } else {
            /* 49 */       for (int i = 0; i < AbstractDungeon.player.potionSlots; i++) {
                /* 50 */         AbstractDungeon.effectsQueue.add(new ObtainPotionEffect(new ColaPotion()));
                /*    */       }
            /*    */     }
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
