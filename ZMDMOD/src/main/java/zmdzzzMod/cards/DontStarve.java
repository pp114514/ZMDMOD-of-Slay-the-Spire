package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.ApplyBulletTimeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.MechanicPower;
import zmdzzzMod.util.CardStats;

public class DontStarve extends BaseCard {
    public static final String ID = makeID(DontStarve.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );

//    private static final int DAMAGE = AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*2 : 0;
//    private static final int UPG_DAMAGE = AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*3 : 0;
    public static int MAGIC=1;
    public static int UPG_MAGIC=1;

    public DontStarve() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(AbstractDungeon.player, magicNumber));
        addToBot(new ApplyBulletTimeAction());
//            addToBot(new DamageAction(m, new DamageInfo(p, AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount * magicNumber : 0, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

//    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
//        if(upgraded){
//            return true;
//        }
//        boolean canUse = false;
//        if(AbstractDungeon.player.hasPower(ScorePower.POWER_ID)) {
//            if (p.getPower(ScorePower.POWER_ID).amount >= 8) {
//                canUse = true;
//            }
//        }
//        return canUse;
//    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DontStarve();
    }
}