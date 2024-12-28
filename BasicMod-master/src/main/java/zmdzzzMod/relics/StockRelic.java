package zmdzzzMod.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.ExamFormPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ShiliPower;

import static com.megacrit.cardcrawl.cards.AbstractCard.CardType.ATTACK;
import static zmdzzzMod.BasicMod.makeID;

public class StockRelic extends BaseRelic {
    private static final String NAME = "StockRelic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.BOSS; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.
//    public static int cnt = 0;

    private static final int STRENGTH = 10; //For convenience of changing it later and clearly knowing what the number means instead of just having a 10 sitting around in the code.

    public StockRelic() {
        super(ID, NAME, zmd.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void atBattleStart() {
        int ctr=(int)(Math.random()*2);
        if(ctr<1) {
            AbstractDungeon.player.gainGold(AbstractDungeon.player.gold/2);
        }
        if(ctr>=1) {
            AbstractDungeon.player.loseGold(AbstractDungeon.player.gold/2);
        }
    }
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
