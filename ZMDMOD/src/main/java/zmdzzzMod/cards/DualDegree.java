package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.*;
import zmdzzzMod.util.CardStats;

public class DualDegree extends BaseCard {
    public static final String ID = makeID(DualDegree.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            1
    );

//    private static final int DAMAGE = AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*2 : 0;
//    private static final int UPG_DAMAGE = AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*3 : 0;
    public static int MAGIC=2;
    public static int UPG_MAGIC=1;

    public DualDegree() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.player.hasPower(MechanicPower.POWER_ID)&& ! AbstractDungeon.player.hasPower(CSPower.POWER_ID)) {
            addToBot(new ApplyPowerAction(p, p, new CSPower(AbstractDungeon.player, 1)));
            addToTop((AbstractGameAction)new RemoveSpecificPowerAction(p,p, MechanicPower.POWER_ID));
        }
        if(AbstractDungeon.player.hasPower(CSPower.POWER_ID)&& ! AbstractDungeon.player.hasPower(MechanicPower.POWER_ID)) {
            addToBot(new ApplyPowerAction(p, p, new MechanicPower(AbstractDungeon.player, 1)));
            addToTop((AbstractGameAction)new RemoveSpecificPowerAction(p,p, CSPower.POWER_ID));
        }
            addToBot(new DamageAction(m, new DamageInfo(p, AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount * magicNumber : 0, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        if(upgraded){
            return true;
        }
        boolean canUse = false;
        if(AbstractDungeon.player.hasPower(ScorePower.POWER_ID)) {
            if (p.getPower(ScorePower.POWER_ID).amount >= 5) {
                canUse = true;
            }
        }
        return canUse;
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DualDegree();
    }
}