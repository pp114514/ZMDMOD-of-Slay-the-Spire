package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.util.CardStats;

public class KMP extends BaseCard {
    public static final String ID = makeID(KMP.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    );

//    private static final int DAMAGE = 10;
//    private static final int UPG_DAMAGE = 3;
//    private static final int MAGIC=2;
//    private static final int UPG_MAGIC=1;

    public KMP() {
        super(ID, info);
        setCostUpgrade(1);
//        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        double ctrl=Math.random();
        addToBot(new LoseHPAction(m, m,(int)(ctrl*100)));
        addToBot(new LoseHPAction(p, p,(int)(ctrl*10)));
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = true;
        if(!AbstractDungeon.player.hasPower(CSPower.POWER_ID)) {
           return false;
        }
        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if(c.type==CardType.ATTACK){
                canUse = false;
            }
        }
        return canUse;
    }

//    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
//        boolean canUse = false;
//        if(AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)) {
//            if (p.getPower(HomeworkPower.POWER_ID).amount >= magicNumber) {
//                canUse = true;
//            }
//        }
//        return canUse;
//    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new KMP();
    }
}