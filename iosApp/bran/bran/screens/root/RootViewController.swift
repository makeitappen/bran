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
    
    override internal var _presenter: Presenter { return presenter }
    private let presenter = RootPresenter()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        //        set(presenter: presenter)
        
        let newsViewController = "News".instantiateInitialViewController()
        let navigationController = UINavigationController(rootViewController: newsViewController)
        navigationController.tabBarItem = UITabBarItem(title: "News", image: nil, tag: 0)
        viewControllers = [navigationController]
        
    }
    
    override func tabBar(_ tabBar: UITabBar, didSelect item: UITabBarItem) {
        if let index = tabBar.items?.firstIndex(of: item) {
            presenter.tabSelected(index: Int32(index))
        }
    }
    
}

extension RootViewController: RootViewI {
    
    func showTab(index: Int32) -> Bool {
        let i = Int(index)
        if i >= 0 && i < viewControllers?.count ?? 0 {
            selectedIndex = i
            return true
        }
        return false
    }
}
