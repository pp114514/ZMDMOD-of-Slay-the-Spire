package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.DeadLinePower;
import zmdzzzMod.powers.DeadLineUpgPower;
import zmdzzzMod.util.CardStats;

public class DeadLine extends BaseCard {
    public static final String ID = makeID(DeadLine.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            7
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
//    private static final int MAGIC=2;
//    private static final int UPG_MAGIC=2;

    public DeadLine() {
        super(ID, info);
//        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
        setEthereal(true,false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(!upgraded) {
            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DeadLinePower(AbstractDungeon.player, 1)));
        }
        else{
            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DeadLineUpgPower(AbstractDungeon.player, 1)));
        }
        addToBot(new GainEnergyAction(999));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new DeadLine();
    }
}