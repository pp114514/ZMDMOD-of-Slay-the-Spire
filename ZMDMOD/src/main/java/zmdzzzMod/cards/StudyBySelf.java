package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.ScorePower;
import zmdzzzMod.util.CardStats;

import static zmdzzzMod.cards.DualDegree.UPG_MAGIC;

public class StudyBySelf extends BaseCard {
    public static final String ID = makeID(StudyBySelf.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            0
    );

    private static final int DAMAGE = 1;
    private static final int UPG_DAMAGE = 0;
    public static int MAGIC=10;
    public static int UPG_MAGIC=-9;
    public StudyBySelf() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.
        this.isMultiDamage = true;

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        //        addToBot((AbstractGameAction) new WhirlwindAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, 1));
        addToBot((AbstractGameAction)new DrawCardAction(AbstractDungeon.player.hasPower(ScorePower.POWER_ID)?AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount%magicNumber:0));
    }


        @Override
    public AbstractCard makeCopy() { //Optional
        return new StudyBySelf();
    }
}