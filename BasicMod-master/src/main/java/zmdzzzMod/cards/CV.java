package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.DivinityStance;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ScorePower;
import zmdzzzMod.util.CardStats;

public class CV extends BaseCard {
    public static final String ID = makeID(CV.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    );

//    private static final int DAMAGE = 3;
//    private static final int UPG_DAMAGE = 2;
//    private static final int MAGIC = 2;
//    private static final int UPG_MAGIC = 2;

    public CV() {
        super(ID, info);

//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.
//        setMagic(MAGIC, UPG_MAGIC);
//        this.isMultiDamage = true;

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
//        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
//        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, magicNumber)));
//        for(int i = 1; i<=(AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)?AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount:0); i++){
//        addToBot(new DamageRandomEnemyAction(new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
//        }
        addToBot(new ChangeStanceAction(DivinityStance.STANCE_ID));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new BucketSort(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new CloudStorage(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new ConfigEnvironment(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Cpp(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Hash(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new KMP(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new MIT6092(),1));
        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new SA(),1));
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = false;
        if(AbstractDungeon.player.hasPower(CSPower.POWER_ID)) {
            canUse = true;
        }
        return canUse;
    }

        @Override
    public AbstractCard makeCopy() { //Optional
        return new CV();
    }
}