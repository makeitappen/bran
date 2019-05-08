//
//  RootViewController.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared

class RootViewController: PresenterTabBarViewController {
    
    private let presenter = RootPresenter()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        set(presenter: presenter)
    }
    
    override func tabBar(_ tabBar: UITabBar, didSelect item: UITabBarItem) {
        if let index = tabBar.items?.firstIndex(of: item) {
            presenter.tabSelected(index: Int32(index))
        }
    }
    
}




extension RootViewController: RootViewI {
    
    func showTab(index: Int32) -> Bool {
        return false
    }
}
