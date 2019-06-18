package com.afei.config.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author gongxiangfei
 * @describe 自定义队列同步器
 * @dataTime 2019-03-25 17:02:00
 */
public class QueuedSynchronizerCustom extends AbstractQueuedSynchronizer {


    protected QueuedSynchronizerCustom() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
